package eu.dariah.de.colreg.pojo.api;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;

import eu.dariah.de.colreg.pojo.AccessPojo;
import eu.dariah.de.colreg.pojo.AccrualPojo;
import eu.dariah.de.colreg.pojo.ImagePojo;

@XmlRootElement(name="collection")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendedCollectionApiPojo extends CollectionApiPojo {
	private static final long serialVersionUID = 5030563485613906700L;
	
	private String localizedDescription;
	private Map<String, String> decriptions;
	
	@XmlElementWrapper(name="access_methods")
	@XmlElement(name="access")
	private List<AccessPojo> accessPojos;
	
	@XmlElementWrapper(name="accrual_methods")
	@XmlElement(name="accrual")
	private List<AccrualPojo> accrualPojos;
	
	private String webPage;
	private String eMail;
	private boolean researchDriven;
	private boolean curationDriven;
	
	@XmlElementWrapper(name="images")
	@XmlElement(name="image")
	private List<ImagePojo> images;
	
	
	public List<AccessPojo> getAccessPojos() { return accessPojos; }
	public void setAccessPojos(List<AccessPojo> accessPojos) { this.accessPojos = accessPojos; }
	
	public List<AccrualPojo> getAccrualPojos() { return accrualPojos; }
	public void setAccrualPojos(List<AccrualPojo> accrualPojos) { this.accrualPojos = accrualPojos; }
	
	public String getLocalizedDescription() { return localizedDescription; }
	public void setLocalizedDescription(String localizedDescription) { this.localizedDescription = localizedDescription; }
	
	public Map<String, String> getDecriptions() { return decriptions; }
	public void setDecriptions(Map<String, String> decriptions) { this.decriptions = decriptions; }
	
	public String getWebPage() { return webPage; }
	public void setWebPage(String webPage) { this.webPage = webPage; }
	
	public String geteMail() { return eMail; }
	public void seteMail(String eMail) { this.eMail = eMail; }
	
	public boolean isResearchDriven() { return researchDriven; }
	public void setResearchDriven(boolean researchDriven) { this.researchDriven = researchDriven; }
	
	public boolean isCurationDriven() { return curationDriven; }
	public void setCurationDriven(boolean curationDriven) { this.curationDriven = curationDriven; }
	
	public List<ImagePojo> getImages() { return images; }
	public void setImages(List<ImagePojo> images) { this.images = images; }
}
