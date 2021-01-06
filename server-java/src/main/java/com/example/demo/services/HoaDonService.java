package com.example.demo.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Ban;
import com.example.demo.entities.HoaDon;
import com.example.demo.entities.StatusHoaDon;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.BanRepository;
import com.example.demo.repositories.HoaDonRepository;

@Service
public class HoaDonService {
	@Autowired
	public HoaDonRepository repo;

	@Autowired
	private BanRepository banRepository;

	@Autowired
	private SessionFactory sessionFactory;

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
