package InterfaceConcept;

public class Developing implements BankingClient,Investments{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Developing d=new Developing();
		d.PayCreditcard();
		d.TransferBalance();
		d.Login();
		BankingClient bc=new Developing();
		Investments iv=new Developing();
		

	}

	@Override
	public void PayCreditcard() {
		// TODO Auto-generated method stub
		System.out.println("PayCreditcard implemented");
		
	}

	@Override
	public void TransferBalance() {
		// TODO Auto-generated method stub
		System.out.println("TransferBalance implemented");
	}

	@Override
	public void CheckingBalance() {
		// TODO Auto-generated method stub
		System.out.println("CheckingBalance implemented");
	}

	public void Login() {
	}

	@Override
	public void Investments() {
		// TODO Auto-generated method stub
		
	}
}
