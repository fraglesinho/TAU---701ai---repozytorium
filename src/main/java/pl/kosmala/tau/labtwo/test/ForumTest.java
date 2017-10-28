package pl.kosmala.tau.labtwo.test;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import pl.kosmala.tau.labtwo.forum.Forum;
import pl.kosmala.tau.labtwo.service.ForumImpl;

import java.util.Date;

import static org.mockito.Mockito.when;

public class ForumTest {
    @Test
    public void testReadForum() {
        ForumImpl forum = new ForumImpl();
        Forum forum1 = forum.Read(0);
        when(forum1.getTitle()).thenReturn("Pierwszy Post");
        when(forum1.getShortPost()).thenReturn("Rapsy są tu");
        when(forum1.getMetaData()).thenReturn("impra,ludzie");
        forum1 = forum.Read(2);
        when(forum1.getVisitCount()).thenReturn(691);
        when(forum1.getMetaData()).thenReturn("impra,ludzie");
    }

    @Test
    public void testCreateNewForum() throws Exception {
        ForumImpl forum = new ForumImpl();
        forum.Create(new Forum(3, "Czwarty Wpis","iksde","Itutej teutej" +
                "na imprezie w dyskotece", "i koto na aru",9999, new Date(1507504340)));
        when(forum.Read(3)).thenReturn(ArgumentMatchers.<Forum>isNotNull());
    }

    @Test
    public void testUpdateForum() {
        ForumImpl forum = new ForumImpl();
        forum.Update(0, new Forum(0, "Lewy strzeka gola","naruUso","duże testy!", "wodka",9999, new Date(1502347240)));
        Forum forum1 = forum.Read(1);
        Assert.assertEquals("Lewy strzeka gola",forum1.getTitle());
        when(forum1.getShortPost()).thenReturn("naruUso");
        when(forum1.getMetaData()).thenReturn("wodka");
        when(forum1.getVisitCount()).thenReturn(9999);
    }

    @Test
    public void testDeleteForum() {
        ForumImpl forum = new ForumImpl();
        forum.Delete(2);
        when(forum.equals(3)).thenReturn(Boolean.FALSE);
    }
}

