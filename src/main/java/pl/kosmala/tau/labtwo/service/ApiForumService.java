package pl.kosmala.tau.labtwo.service;

public interface ApiForumService {
    DbConnection setDataSource(DbConnection dataSource);

    DbConnection findRecordsByRegex(String regexString);
    DbConnection deleteRecords(DbConnection objectsToRemove);
}
