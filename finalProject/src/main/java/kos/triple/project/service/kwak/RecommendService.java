package kos.triple.project.service.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface RecommendService {
	//�����׸�
	public void tourismSearch(HttpServletRequest req, Model model);
	
	//�����׸���õ���
	public void restaurantSearch(HttpServletRequest req, Model model);
	
	//�����׸���õ���
	public void leisureSearch(HttpServletRequest req, Model model);
	
	//�����׸���õ���
	public void healingSearch(HttpServletRequest req, Model model);
	
	//���ƿ���׸���õ���
	public void likegSearch(HttpServletRequest req, Model model);
	
	//��ȸ�����׸���õ���
	public void countSearch(HttpServletRequest req, Model model);
}
