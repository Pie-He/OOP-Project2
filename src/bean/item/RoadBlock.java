package bean.item;


public class RoadBlock extends Item{
	@SuppressWarnings("unused")
	private String symbol;
	public RoadBlock(int poi){
		this.setPoi(poi);
		this.type=BlockType.RoadBlock;
	}
	
}
