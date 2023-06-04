package prog;

import java.util.ArrayList;

public class order {
	private String ID;
	private ArrayList<product> op;
	private int sum;
	private boolean payment;
	private int pay;
	private int change;
	
	public order(String ID) {
		
		this.ID = ID;
		op=new ArrayList<product>();
		payment=true;
		sum=0;
		pay=0;
		change=0;
	}
	
	
}


/*
	您可以在類別中定義兩個字段，一個是ArrayList類型，
	另一個是根據ArrayList中的數據運算而來的字段。
	例如，您可以創建一個名為MyClass的類，
	其中包含一個名為myList的ArrayList字段和一個名為myField的字段。

public class MyClass {
    private ArrayList<Object> myList;
   private int myField;

    public MyClass(ArrayList<Object> anotherList) {
        myList = new ArrayList<Object>();
       // 選擇另一個ArrayList中的對象並添加到myList中
        for (Object obj : anotherList) {
            if ( 滿足某些條件 ) {
               myList.add(obj);
            }
        }
        // 根據myList中的數據計算myField的值
        myField = 0;
       for (Object obj : myList) {
            // 根據obj的值更新myField
            myField +=  obj的某些值 ;
        }
    }
}
	在上面的代碼中，MyClass類有兩個字段：myList和myField。
	myList字段在構造函數中初始化，
	並從另一個ArrayList中選擇對象添加到其中。
	myField字段根據myList中的數據計算得出。
	您可以根據需要修改條件以選擇要添加到myList中的對象，
	並根據需要更新myField的計算方法。
*/



