
public class TeamLeader extends Employee implements Labelisable{
	
	private Integer projectNumber;
	
	@Override
	public String getLabel() {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("NAME: ");
		strBuffer.append(super.getName().toUpperCase());
		strBuffer.append(" " + projectNumber);
		return strBuffer.toString();
	}

	public Integer getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(Integer projectNumber) {
		this.projectNumber = projectNumber;
	}
	
}
