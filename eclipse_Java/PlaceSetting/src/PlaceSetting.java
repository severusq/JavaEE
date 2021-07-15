class Plate {
	public Plate(int i) {
		System.out.println("Plate constructor");
	}
}

class DinnerPlate extends Plate { //�̳�
	public DinnerPlate(int i) {
		super(i); //���๹�캯���ĵ��÷ŵ�һ��
		System.out.println("DinnerPlate constructor");
	}
}

class Utensil {
	public Utensil(int i) {
		System.out.println("Utensil constructor");
	}
}

class Spoon extends Utensil {
	public Spoon(int i) {
		super(i); //���Ÿ�������׷�ݣ����ȵ��õ������ϵ������࣬�������Լ�����
		System.out.println("Spoon constructor");
	}
}

class Fork extends Utensil {
	public Fork(int i) {
		super(i);
		System.out.println("Fork constructor");
	}
}

class Knife extends Utensil {
	public Knife(int i) {
		super(i);
		System.out.println("Knife constructor");
	}
}

class Custom {
	public Custom(int i) {
		System.out.println("Custom constructor");
	}
}

public class PlaceSetting extends Custom { //��ϣ�������ϵ����ϣ����ڹ�ϵ�ü̳�
	Spoon sp;
	Fork fk;
	Knife kn;
	DinnerPlate pl;
	public PlaceSetting(int i) {
		super(i);
		sp = new Spoon(i);
		fk = new Fork(i);
		kn = new Knife(i);
		pl = new DinnerPlate(i);
		System.out.println("PlaceSetting constructor");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlaceSetting x = new PlaceSetting(9);
	}

}
