package model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Item {
	@NotEmpty(message="상품코드를 입력하세요")
	private String item_id;
	@NotEmpty(message="상품이름을 입력하세요")
	private String item_name;
	@NotNull(message="가격을 입력하세요")
	@Min(0)
	@Range(min=0, max=1000000, message="{min}과 {max} 사이를 입력해주세요.")
	private Integer price;
	private String info;
	private String origin;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
}
