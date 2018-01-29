package kos.triple.project.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MainService {

	//��õ����⸦ �����´�.
	void getHomePageRecomandList(HttpServletRequest req, Model model);

	//������ �̹����� �����´�.
	void getMyFaceImg(HttpServletRequest req, Model model);

	//����̹����� �����´�.
	void getBanner(HttpServletRequest req, Model model);

	//������ ��ġ�� ����� ������ �����´�.
	void getBannerCount(HttpServletRequest req, Model model);

	//�������ӽ� �˾�(�ֽ� �������� 1�� �����´�)
	void getNewNotice(HttpServletRequest req, Model model);

	
	//öȯ���� ���񽺷� �����.
	void myNewStory(HttpServletRequest req, Model model);

	//ȣ���� ���񽺷� �����.
	void myNewPlan(HttpServletRequest req, Model model);

	
	
}
