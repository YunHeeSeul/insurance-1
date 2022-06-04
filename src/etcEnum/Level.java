package Practice.InsuranceCompany.Design.src.etcEnum;

public enum Level {
	high("상",2),
	middle("중",1),
	low("하",0);

	private int severity;
	private String detail;
	Level(String detail, int severity){
		this.severity = severity;
		this.detail=detail;
	}

	public static Level makeLevel(String detail){
		if(detail.equals(high.getDetail())) return high;
		if(detail.equals(middle.getDetail())) return middle;
		if(detail.equals(low.getDetail())) return low;
		return null;
	}
	public int getLevelNum(){ return this.severity; }

	public String getDetail() {
		return detail;
	}
}