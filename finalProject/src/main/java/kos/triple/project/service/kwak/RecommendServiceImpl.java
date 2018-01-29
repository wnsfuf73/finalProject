package kos.triple.project.service.kwak;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kos.triple.project.persistence.kwak.RecommendDAO;
import kos.triple.project.vo.RecommendVO;

@Service
public class RecommendServiceImpl implements RecommendService {
	
	@Autowired
	RecommendDAO dao;

	//�����׸�
	@Override
	public void tourismSearch(HttpServletRequest req, Model model) {
		String category = "travel";
		
		ArrayList<RecommendVO> dtos = dao.tourismSearch(category);
		model.addAttribute("dtos",dtos);
	}

	//�����׸���õ���
	@Override
	public void restaurantSearch(HttpServletRequest req, Model model) {
		String category = "eat";
		
		ArrayList<RecommendVO> dtos = dao.restaurantSearch(category);
		model.addAttribute("dtos",dtos);
		
	}

	//�����׸���õ���
	@Override
	public void leisureSearch(HttpServletRequest req, Model model) {
		String category = "leisure";
		
		ArrayList<RecommendVO> dtos = dao.leisureSearch(category);
		model.addAttribute("dtos",dtos);
		
	}

	//�����׸���õ���
	@Override
	public void healingSearch(HttpServletRequest req, Model model) {
		String category = "healing";
		
		ArrayList<RecommendVO> dtos = dao.healingSearch(category);
		model.addAttribute("dtos",dtos);
		
	}

	//���ƿ���׸���õ���
	@Override
	public void likegSearch(HttpServletRequest req, Model model) {
		
		ArrayList<RecommendVO> dtos = dao.likeSearch();
		model.addAttribute("dtos",dtos);
		
	}

	//��ȸ�����׸���õ���
	@Override
	public void countSearch(HttpServletRequest req, Model model) {
		
		ArrayList<RecommendVO> dtos = dao.countSearch();
		model.addAttribute("dtos",dtos);
		
	}
}
