package com.example.demo.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.DocumentEvent.ElementChange;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Ban;
import com.example.demo.entities.ChiTietHoaDon;
import com.example.demo.entities.HoaDon;
import com.example.demo.entities.MonAn;
import com.example.demo.entities.StatusHoaDon;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.ChiTietHoaDonPayload;
import com.example.demo.payload.ChiTietHoaDonRequest;
import com.example.demo.repositories.BanRepository;
import com.example.demo.repositories.ChiTietHoaDonRepository;
import com.example.demo.repositories.HoaDonRepository;
import com.example.demo.repositories.MonAnRepository;

@Service
@Transactional
public class HoaDonService {
	@Autowired
	public HoaDonRepository repo;

	@Autowired
	private BanRepository banRepository;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ChiTietHoaDonRepository chiTietHoaDonRepository;

	@Autowired
	private MonAnRepository monAnRepository;

	public void getBan(ChiTietHoaDonRequest cthdRequest) {
		System.out.println(cthdRequest.getBan_stt());
	}

	public void checkout(ChiTietHoaDonRequest cthdRequest) {

		Ban object = banRepository.findBySTT(cthdRequest.getBan_stt());

		/* Hoa Don */
		HoaDon hoaDon = new HoaDon();
		hoaDon.setBan(object);

		hoaDon.setHd_trangthai(StatusHoaDon.Dathanhtoan);
		hoaDon.setHd_tongtien(cthdRequest.getTotal());
		hoaDon.setHd_ngaythanhtoan(this.getCurrentDate());

		System.out.print(hoaDon.getHd_tongtien());

		HoaDon hd = repo.save(hoaDon);

		/* END - Hoa Don */

		var list = cthdRequest.getOrderdetail();

		for (int i = 0; i < list.size(); i++) {
			ChiTietHoaDonPayload element = new ChiTietHoaDonPayload(list.get(i));
			MonAn monAn = monAnRepository.findById(element.getMonAn()).orElseThrow(
					() -> new ResourceNotFoundException("Mon an khong ton tai with: " + element.getMonAn()));

			ChiTietHoaDon cthd = new ChiTietHoaDon();
			cthd.setCthd_gia(element.getCthd_gia());
			cthd.setCthd_soluong(element.getCthd_soluong());
			cthd.setHoaDon(hd);
			cthd.setMonAn(monAn);

			chiTietHoaDonRepository.save(cthd);
		}
	}

	public Long getIdByTable(Long idBan) {
		Session session = sessionFactory.getCurrentSession();

		Query<HoaDon> query = session
				.createQuery("from HoaDon hd join hd.ban where hd.ban.hd_id=:id and hd.tinhtrang = 1", HoaDon.class);

		query.setParameter("id", idBan);
		HoaDon hoaDon = query.uniqueResult();

		if (hoaDon == null) {
			return (long) -1;
		}

		return hoaDon.getHd_id();
	}

	private Date getCurrentDate() {
		// default time zone
		ZoneId defaultZoneId = ZoneId.systemDefault();

		// creating the instance of LocalDate using the day, month, year info
		LocalDate localDate = LocalDate.now();

		Date currentDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		return currentDate;
	}

	public HoaDon checkoutHoaDon(Long id, double tongtien) {
		HoaDon hoaDon = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hoa don khong ton tai with: " + id));

		hoaDon.setHd_trangthai(StatusHoaDon.Dathanhtoan);
		hoaDon.setHd_tongtien(tongtien);
		hoaDon.setHd_ngaythanhtoan(this.getCurrentDate());

		HoaDon hd = repo.save(hoaDon);

		return hd;
	}

	public HoaDon addHoaDonTheoBan(Long idBan) {
		HoaDon hd = new HoaDon();
		Ban object = banRepository.findById(idBan)
				.orElseThrow(() -> new ResourceNotFoundException("Ban an khong ton tai with: " + idBan));

		hd.setHd_trangthai(StatusHoaDon.ChuaThanhToan);
		hd.setBan(object);

		HoaDon savedHoaDon = repo.save(hd);

		return savedHoaDon;
	}
}
