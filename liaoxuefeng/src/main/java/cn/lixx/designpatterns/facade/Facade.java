package cn.lixx.designpatterns.facade;

import cn.lixx.designpatterns.facade.organization.AdminOfIndustry;
import cn.lixx.designpatterns.facade.organization.Bank;
import cn.lixx.designpatterns.facade.organization.Company;
import cn.lixx.designpatterns.facade.organization.Taxation;

public class Facade {

	private AdminOfIndustry admin = new AdminOfIndustry();
	private Bank bank = new Bank();
	private Taxation taxation = new Taxation();

	public Company openCompany(String name) {
		Company c = this.admin.register(name);
		String bankAccount = this.bank.openAccount(c.getId());
		c.setBankAccount(bankAccount);
		String taxCode = this.taxation.applyTaxCode(c.getId());
		c.setTaxCode(taxCode);
		return c;
	}
}
