package de.fzi.cep.sepa.model.impl.quality;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.clarkparsia.empire.annotation.Namespaces;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;

import de.fzi.cep.sepa.model.UnnamedSEPAElement;

@Namespaces({"sepa", "http://sepa.event-processing.org/sepa#",
	 "ssn",   "http://purl.oclc.org/NET/ssnx/ssn#"})
@RdfsClass("sepa:EventPropertyQualityRequirement")
@MappedSuperclass
@Entity
public class EventPropertyQualityRequirement extends UnnamedSEPAElement {

	private static final long serialVersionUID = -8173312776233284351L;

	@OneToOne(cascade = {CascadeType.ALL})
	@RdfProperty("sepa:minimumEventPropertyQuality")
	transient EventPropertyQualityDefinition minimumPropertyQuality;

	@OneToOne(cascade = {CascadeType.ALL})
	@RdfProperty("sepa:maximumEventPropertyQuality")
	transient EventPropertyQualityDefinition maximumPropertyQuality;
	
	public EventPropertyQualityRequirement() {
		super();
	}

	public EventPropertyQualityRequirement(
			EventPropertyQualityDefinition minimumPropertyQuality,
			EventPropertyQualityDefinition  maximumPropertyQuality) {
		
		super();
		this.minimumPropertyQuality = minimumPropertyQuality;
		this.maximumPropertyQuality = maximumPropertyQuality;
	}
	
	public EventPropertyQualityRequirement(EventPropertyQualityRequirement other) {
		super(other);
		//this.minimumPropertyQuality = other.getMinimumPropertyQuality();
		//this.maximumPropertyQuality = other.getMaximumPropertyQuality();
	}

	public EventPropertyQualityDefinition getMinimumPropertyQuality() {
		return minimumPropertyQuality;
	}

	public void setMinimumPropertyQuality(
			EventPropertyQualityDefinition minimumPropertyQuality) {
		this.minimumPropertyQuality = minimumPropertyQuality;
	}

	public EventPropertyQualityDefinition getMaximumPropertyQuality() {
		return maximumPropertyQuality;
	}

	public void setMaximumPropertyQuality(
			EventPropertyQualityDefinition maximumPropertyQuality) {
		this.maximumPropertyQuality = maximumPropertyQuality;
	}
}