
public class FeuBicolor extends Semaphore {

	protected boolean Feu1;
	protected boolean Feu2;
	
	public FeuBicolor () {

		this.Feu1=false;
		this.Feu2=true;
			
	    };

	    
	    boolean isGreen(){
	    	return this.Feu1;
	    }
	    
	    void toGreen(){
	    	this.Feu1=true;
	    	this.Feu2=false;
	    }
	    
}