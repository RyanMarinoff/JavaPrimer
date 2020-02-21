package com.revature.ers.data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
public class Manager extends User {

	@Override
	public int hashCode() {
		final int prime = 37;
		int result = super.hashCode();
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Manager))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Manager [id=");
		builder.append(this.getId());
		builder.append(", username=");
		builder.append(this.getUsername());
		builder.append(", password=");
		builder.append(this.getPassword());
		builder.append(", email=");
		builder.append(this.getEmail());
		builder.append(", first=");
		builder.append(this.getFirst());
		builder.append(", last=");
		builder.append(this.getLast());
		builder.append("]");
		return builder.toString();
	}

}
