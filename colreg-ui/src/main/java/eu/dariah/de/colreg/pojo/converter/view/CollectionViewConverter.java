package eu.dariah.de.colreg.pojo.converter.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Component;

import eu.dariah.de.colreg.model.Collection;
import eu.dariah.de.colreg.pojo.converter.base.BaseCollectionConverter;
import eu.dariah.de.colreg.pojo.view.CollectionViewPojo;

@Component
public class CollectionViewConverter extends BaseCollectionConverter<CollectionViewPojo> {	
		
	@Override
	public CollectionViewPojo convertToPojo(Collection collection, Locale locale) {
		return this.convertToPojo(collection, null, locale);
	}
	
	public List<CollectionViewPojo> convertToPojos(List<Collection> collections, Locale locale, Map<String, String> accessTypeIdLabelsMap) {
		if (collections==null || collections.isEmpty()) {
			return new ArrayList<CollectionViewPojo>(0);
		}
		List<CollectionViewPojo> pojos = new ArrayList<CollectionViewPojo>(collections.size());
		for (Collection collection : collections) {
			pojos.add(this.convertToPojo(collection, accessTypeIdLabelsMap, locale));
		}
		return pojos;
	}
	
	public CollectionViewPojo convertToPojo(Collection collection, Map<String, String> accessTypeIdLabelsMap, Locale locale) {
		CollectionViewPojo pojo = new CollectionViewPojo();
		pojo.setId(collection.getEntityId());
		pojo.setDeleted(collection.isDeleted());
		pojo.setPublished(collection.getDraftUserId()==null || collection.getDraftUserId().isEmpty());
		pojo.setDraft(!pojo.isPublished());
		
		pojo.setCollectionTypeIdentifiers(collection.getCollectionTypes());

		pojo.setTimestamp(collection.getVersionTimestamp().toInstant().getMillis());
		pojo.setDisplayTimestamp(this.getDisplayTimestamp(collection.getVersionTimestamp(), locale));
		
		if (collection.getAccessMethods()!=null && collection.getAccessMethods().size()>0 && accessTypeIdLabelsMap!=null) {
			pojo.setAccessTypes(new ArrayList<String>(collection.getAccessMethods().size()));
			for (int i=0; i<collection.getAccessMethods().size(); i++) {
				pojo.getAccessTypes().add(accessTypeIdLabelsMap.get(collection.getAccessMethods().get(i).getType()));
			}
		}

		pojo.setDisplayTitle(this.getLocalizedOrDefaultTitle(collection, locale));
		String acronym = this.getLocalizedOrDefaultAcronym(collection, locale);
		if (acronym!=null && !acronym.trim().isEmpty()) {
			pojo.setDisplayTitle(pojo.getDisplayTitle() + " [" + acronym + "]");
		}
		
		
		pojo.setPrimaryImage(this.getPrimaryImage(collection));
		
		return pojo;
	}
}
