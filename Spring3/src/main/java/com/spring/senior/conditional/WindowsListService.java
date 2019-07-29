package com.spring.senior.conditional;
/*Windows下所要创建的 Bean的类*/
public class WindowsListService implements ListService {

	@Override
	public String showListCmd() {
		return "dir";
	}

}
