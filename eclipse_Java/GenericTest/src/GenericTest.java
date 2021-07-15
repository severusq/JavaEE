
class GeneralType <Type extends Number> { //泛型编程，用法同c++，这里设置Type必须是Number类或Number的子类
	Type object;
	public GeneralType(Type object) { //定义泛型函数的语法是在public前加<Type>
		this.object = object;
	}
	public Type getObj() {
		return object;
	}
}

class showType {
	public void showType(GeneralType<?> o) { //?是通配符，代表任意一种泛型，不然都会变成Object类
		System.out.println(o.getObj().getClass().getName()); //获取Type所属的类的名字
	}
}
public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showType st = new showType();
		GeneralType<Integer> i = new GeneralType<Integer> (2);
		//GeneralType<String> s = new GeneralType<String>("Hello"); //有限制就不能用这一句了
		st.showType(i);
		//st.showType(s);
	}

}
