package Bank;

import java.util.Scanner;

class Host
{
	int mymoney;
	int five;
	int one;

	public Host(int money, int fi, int on)
	{
		mymoney = money;
		five = fi;
		one = on;
	}
	public int out(int money)
	{
		mymoney-=money;
		return money;
	}
	public int in(int money)
	{
		mymoney+=money;
		return money;
	}
	public void result_Deal()
	{
		System.out.println(mymoney + "원");
	}
}

class Customer
{
	int getmoney;

	public Customer(int money)
	{
		getmoney = money;
	}
	public int inMoney(Host save, int m)
	{
		m = save.out(m);
		getmoney += m;
		return m;
	}
	public int outMoney(Host save, int m)
	{
		m = save.out(m);
		getmoney -= m;
		return m;
	}
	public void Guest()
	{
		System.out.println(getmoney + "원");
	}
}

class Bank
{
	public static void main(String[] args)
	{
		int inout;
		Host h = new Host(1000000, 15, 25);
		Customer c = new Customer(1000000);

		System.out.println("거래 전 통장 잔고");
		h.result_Deal();
		while(true)
		{
			System.out.println("1. 출금\t 2. 입금");
			Scanner num = new Scanner(System.in);
			inout = num.nextInt();
			if(inout == 1)
			{
				while(true)
				{
					Scanner output = new Scanner(System.in);
					c.inMoney(h, output.nextInt());

					if(h.mymoney < 0)
					{
						System.out.println("통장에 잔액이 부족합니다.");
						break;
					}

					System.out.println("거래 후 통장 잔고");
					h.result_Deal();

					System.out.println("고객의 현재 상황");
					c.Guest();
				}
			}
			else if(inout == 2)
			{
				while(true)
				{
					Scanner output = new Scanner(System.in);
					c.outMoney(h, output.nextInt());

					if(output.nextInt() > c.getmoney)
					{
						System.out.println("가진 돈을 초과하였습니다.");	  
						break;
					}

					if(h.mymoney < 0)
						break;
					System.out.println("거래 후 통장 잔고");
					h.result_Deal();
					System.out.println("고객의 현재 상황");
					c.Guest();
				}
			}
			else
				break;
		}
	}
}