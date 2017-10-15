package pl.kosmala.tau.labone.service;

import pl.kosmala.tau.labone.forum.Forum;

public interface ForumService {

    int Create(Forum forum) throws Exception;
    Forum Read(int id);

    void Update(int id, Forum forum);

    void Delete(int id);
}
