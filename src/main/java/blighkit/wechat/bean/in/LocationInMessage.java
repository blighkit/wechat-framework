package blighkit.wechat.bean.in;

public class LocationInMessage extends InMessage {

	private String LocationX;
	private String LocationY;
	private Long Scale;
	private String Label;

	public LocationInMessage(String LocationX, String LocationY, Long Scale,
			String Label) {
		this.LocationX = LocationX;
		this.LocationY = LocationY;
		this.Label = Label;
		this.Scale = Scale;

	}

	public String getLocationX() {
		return LocationX;
	}

	public void setLocationX(String locationX) {
		LocationX = locationX;
	}

	public String getLocationY() {
		return LocationY;
	}

	public void setLocationY(String locationY) {
		LocationY = locationY;
	}

	public Long getScale() {
		return Scale;
	}

	public void setScale(Long scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

}
