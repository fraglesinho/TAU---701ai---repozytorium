package pl.kosmala.tau.labone.service;

import pl.kosmala.tau.labone.forum.Forum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForumImpl implements ForumService {
    private List<Forum> arrayOfForums = new ArrayList<Forum>();

    public ForumImpl() {
        arrayOfForums.add(new Forum(0, "Pierwszy Post","Rapsy są tu","Rapsy są tu" +
                "Rapsy są tu", "impra,ludzie",5, new Date(1507107200)));
       arrayOfForums.add(new Forum(1, "Dwa Sławy...ne posty","Rapsy też tam","Rapsy są tam" +
                "Rapsy są tu", "impra,ludzie",2, new Date(1507547230)));
       arrayOfForums.add(new Forum(2, "Trzy ggole chelsea","Chelsea gola","Impra jest" +
                "Chelsea gola", "impra,ludzie",691, new Date(1507517000)));
    }
    @Override
    public int Create(Forum forum) throws Exception {
        for (Forum _forum : arrayOfForums) {
            if (_forum.getId() == forum.getId()){
                throw new Exception();
            }
        }
        arrayOfForums.add(forum);
        return forum.getId();
    }

    @Override
    public Forum Read(int id) {
        return arrayOfForums.get(id);
    }

    @Override
    public void Update(int id,Forum forum) {
        arrayOfForums.set(id,forum);
    }

    @Override
    public void Delete(int id) {
        arrayOfForums.remove(id);
    }
}
