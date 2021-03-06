/**
 * 
 */
package org.sdrc.mis.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@Entity
public class DeviceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deviceId;

	@Column(nullable = false)
	private String deviceName;

	// device code will be auto generated by the system depending on deviceType
	@Column(nullable = false, unique = true)
	private String deviceCode;

	@ManyToOne
	@JoinColumn(nullable = false)
	private TypeDetail deviceType;

	@Column(nullable = false, unique = true)
	private String barCode;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String createdBy;

	@CreationTimestamp
	@Column(nullable = false)
	private Timestamp createdDate;

	private String updatedBy;

	@UpdateTimestamp
	private Timestamp updatedDate;

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public TypeDetail getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(TypeDetail deviceType) {
		this.deviceType = deviceType;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}
