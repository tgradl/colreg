package eu.dariah.de.colreg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import eu.dariah.de.colreg.dao.vocabulary.generic.VocabularyItemDao;
import eu.dariah.de.colreg.model.vocabulary.generic.VocabularyItem;

@Service
public class VocabularyItemServiceImpl implements VocabularyItemService {
	@Autowired private VocabularyItemDao vocabularyItemDao;
	
	@Override
	public List<VocabularyItem> findVocabularyItems(String vocabularyId) {
		return vocabularyItemDao.find(Query.query(Criteria.where("vocabularyId").is(vocabularyId)));
	}
}
