
/* a virtual pigeon receives food on either left (fs0) or right (fs1) side with random allocation. 
 * if after 9 tries one side significantly prevails (ratio), the pigeon learns to expect food on that side.
 * however, if the pigeon sees it's not receiving food on the chosen side more often than expected from random allocation,
 * it 'unlearns' and goes back to choosing sides at random. it starts expecting food on a given side again if it becomes more 'successful'.
 */

public class AIPigeonMain {
	int tries, resF, resP, fs0, fs1;  //result for food (0 or 1), result for pigeon (0 or 1), nº of times food appears on either side
	double ratio;  // ratio after which te pigeon realizes success rate of one side is significant; controls 'intelligence' of the pigeon
	String foodState, pigeonState;
	
	public static void main(String[] args) {
		new AIPigeonMain();
	}
	public AIPigeonMain() {
		tries=20; ratio=1.2;
		for(int i=0; i<tries; i++) {
			System.out.print(i+1+". ");
			resF = (int)(Math.random()*10+1); //side with food chosen at random with equal probability
			if(resF<=5) { foodState="0"; fs0++; } else if(resF>5) { foodState="1"; fs1++; }
			System.out.print("foodState "+foodState);
			// pigeon learns food is more likely to appear on a given side
			if(fs0+fs1>9 && fs0/fs1>ratio) { pigeonState="0"; System.out.print(" (learned 0)"); }
			else if(fs0+fs1>9 && fs1/fs0>ratio) { pigeonState="1"; System.out.print(" (learned 1)"); }
			else {
				resP = (int)(Math.random()*10+1);  // if no statistically significant difference, the pigeon continues to choose food at random
				if(resP<=5) { pigeonState="0"; } else if(resP>5) { pigeonState="1"; }
			}
			
			System.out.println(" pigeonState "+pigeonState);

		}
	}
}
