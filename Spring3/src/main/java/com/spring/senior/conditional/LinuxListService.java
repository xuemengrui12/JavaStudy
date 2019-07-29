package com.spring.senior.conditional;
/*Linux下所要创建的 Bean的类*/
public class LinuxListService implements ListService{

	@Override
	public String showListCmd() {
		return "ls";
	}

}
