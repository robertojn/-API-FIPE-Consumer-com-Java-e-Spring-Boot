package br.com.roberto.TabelaFipe.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.boot.json.JsonParseException;

import java.util.List;

public class ConverterDados  implements IConverteDados{


    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        }catch (JsonParseException e)
        {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) {

            CollectionType lista = mapper.getTypeFactory()
                    .constructCollectionType(List.class, classe);

            try{
                return mapper.readValue(json, lista);
            }catch (JsonParseException e)
            {
                throw new RuntimeException(e);
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

    }
}
