package calc;

public class SingleField {
	  boolean open=false;
	  boolean flag=false;
	  boolean mine=false;
	  boolean exploded=false;
	  int  count=0;
	  
	  public SingleField() {};
	  
	  public boolean getOpen() {
		  return open;
	  }
	  
	  public void setOpen() {
		  open=true;
	  }
	  
	  public void setFlag() {
		  flag=!flag;
	  }
	  
	  public boolean getFlag() {
		  return flag;
	  }
	  
	  public boolean getMine() {
		  return mine;
	  }
	  
	  public void setMine() {
		  mine=true;
	  }
	  
	  public boolean getExploaded() {
		  return exploded;
	  }
	  
	  public void setExploaded() {
		  exploded=true;
	  }
	  
	  public int getCount() {
		  return count;
	  }
	  
	  public void setCount(int c) {
		  count=c;
	  }
	  
	  public void addCount() {
		  count++;
	  }
}
