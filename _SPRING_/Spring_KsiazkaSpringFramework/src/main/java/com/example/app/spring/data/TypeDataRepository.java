package com.example.app.spring.data;

import com.example.app.java.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository()
public class TypeDataRepository implements TypeDataDAO{
    private static final Logger log = LoggerFactory.getLogger(TypeDataRepository.class);
    private Map<String, Type> types = new HashMap<>();

    public TypeDataRepository() {
        Type type1 = new Type();
        type1.setName("PDF");
        type1.setDesc("Portable Document Format");
        type1.setExtension(".pdf");

        Type type2 = new Type();
        type2.setName("NOTE");
        type2.setDesc("Notatki tekstowe");
        type2.setExtension(".txt");

        Type type3 = new Type();
        type3.setName("WEB");
        type3.setDesc("Łącze sieciowe");
        type3.setExtension(".url");

        types.put("webType", type3);
        types.put("pdfType", type1);
        types.put("noteType", type2);
    }

    public Map<String, Type> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Type> types) {
        this.types = types;
    }

    @Override
    public Type[] getAll() {
        return types.values().toArray(new Type[types.values().size()]);
    }

    @Override
    public Type findById(String id) {
        if (log.isDebugEnabled()) {
            log.debug("Początek metody findById: " + id);
        }
        Type type = types.get(id);

        if (log.isDebugEnabled()) {
            log.debug("Koniec meotdy findById: " + type);
        }
        return type;
    }
}
