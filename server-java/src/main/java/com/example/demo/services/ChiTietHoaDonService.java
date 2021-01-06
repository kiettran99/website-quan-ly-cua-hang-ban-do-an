package com.example.demo.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChiTietHoaDon;
import com.example.demo.repositories.BanRepository;
import com.example.demo.repositories.ChiTietHoaDonRepository;
import com.example.demo.repositories.HoaDonRepository;

@Service
public class ChiTietHoaDonService {
	@Autowired
	public ChiTietHoaDonRepository repo;

	@Autowired
	private HoaDonRepository hoaDonRepository;

	@Autowired
	private BanRepository banRepository;

	@Autowired
	private SessionFactory sessionFactory;

	public ChiTietHoaDon getChiTietHoaDonTheoBan(Long idBan) {
		Session session = sessionFactory.getCurrentSession();

		String queryString = " Form ChiTietHoaDon cthd join cthd.hoaDon join cthd.monAn join cthd.hoaDon.ban "
				+ "Where cthd.hoaDon.ban.b_id = :id and  cthd.hoaDon.hd_trangthai = 1";

		Query<ChiTietHoaDon> query = session.createQuery(queryString, ChiTietHoaDon.class);

		query.setParameter("id", idBan);
		ChiTietHoaDon cthd = query.uniqueResult();

		return cthd;
	}

	public ChiTietHoaDon removeChiTietHoaDon(Long idBan, Long idThucAn) {
		Session session = sessionFactory.getCurrentSession();

		String queryString = "delete from ChiTietHoaDon cthd join cthd.monAn join cthd.hoaDon cthd where cthd.monAn.ma_id = :id_thucan and cthd.hoaDon.hd_id = (select hd.hd_id from HoaDon hd where hd.b_id = :id_ban and hd.hd_trangthai = 1)";

		Query<ChiTietHoaDon> query = session.createQuery(queryString, ChiTietHoaDon.class);

		query.setParameter("id_thucan", idThucAn);
		query.setParameter("id_ban", idBan);
		ChiTietHoaDon cthd = query.uniqueResult();

		return cthd;
	}
}
