package defaultpackage;

public class LaunchClassForNameEx {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
//		Class.forName("Demo").newInstance();
//		Demo d = new Demo();
		Class.forName("defaultpackage.Demo").newInstance();
	}

}

class Demo
{
	static
	{
		System.out.println("Static BLock");
	}
	
	{
		System.out.println("Instance block ==> Non static");
	}
}
