package pl.kosmala.tau.labone.test;


import org.junit.Assert;
import org.junit.Test;
import pl.kosmala.tau.labone.forum.Forum;
import pl.kosmala.tau.labone.service.ForumImpl;

import java.util.Date;

public class ForumTest {
    @Test
    public void testReadForum() {
        ForumImpl forum = new ForumImpl();
        Forum forum1 = forum.Read(0);
        Assert.assertEquals("Pierwszy Post",forum1.getTitle());
        Assert.assertEquals("Rapsy są tu",forum1.getShortPost());
        Assert.assertEquals("impra,ludzie",forum1.getMetaData());
        forum1 = forum.Read(2);
        Assert.assertEquals(691,forum1.getVisitCount());
        Assert.assertEquals("impra,ludzie",forum1.getMetaData());
    }

    @Test
    public void testCreateNewForum() throws Exception {
        ForumImpl forum = new ForumImpl();
        forum.Create(new Forum(3, "Czwarty Wpis","iksde","Itutej teutej" +
                "na imprezie w dyskotece", "i koto na aru",9999, new Date(1507504340)));
        Assert.assertNotNull(forum.Read(3));
    }

    @Test
    public void testUpdateForum() {
        ForumImpl forum = new ForumImpl();
        forum.Update(0, new Forum(0, "Lewy strzeka gola","naruUso","duże testy!", "wodka",9999, new Date(1502347240)));
        Forum forum1 = forum.Read(1);
        Assert.assertEquals("Lewy strzeka gola",forum1.getTitle());
        Assert.assertEquals("naruUso",forum1.getDescription());
        Assert.assertEquals("wodka",forum1.getMetaData());
        Assert.assertEquals(9999,forum1.getVisitCount());
    }

    @Test
    public void testDeleteForum() {
        ForumImpl forum = new ForumImpl();
        forum.Delete(2);
        Assert.assertFalse(forum.equals(3));
    }
}

