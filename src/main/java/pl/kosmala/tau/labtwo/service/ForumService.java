package pl.kosmala.tau.labtwo.service;

import pl.kosmala.tau.labtwo.forum.Forum;

public interface ForumService {

    int Create(Forum forum) throws Exception;
    Forum Read(int id);

    void Update(int id, Forum forum);

    void Delete(int id);
}
