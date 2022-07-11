package com.cinemon.domain.services;

public interface PlexService {

    void getSessions();

    void getSessionsTerminate();

    void getMetadata(String ratingKey);

    void getMetadataChildren(String ratingKey, String sectionId, boolean artist, boolean collection);

    void getMetadataGrandChildren(String ratingKey);

    void getPlaylistItem(String ratingKey);

    void getRecentlyAdded(String start, String count);

    void getLibraryRecetlyAdded(String sectionId, String start, String count);

    void getChildrenListRelated(String ratingKey);

    void getChildrensList(String ratingKey);

    void getServerList();

    void getServerPrefs();

    void getLocalServerIdentity();

    void getLibrariesList();

    void getLibraryList(String sectionId, String listType, String count, String sortType, String labelKey);

    void getLibraryLabels(String sectionId);

    void getSyncItems(String syncId);

    void getSyncTranscodeQueue();

    void getSearch(String query, String limit);

    void getAccount();

    void putRefreshReachability();

    void putUpdater();

    void getUpdater();

    void getHubRecentlyAdded(String start, String count, String mediaType, boolean otherVideo);

    void getRecentlyAddedDetails(String start, String count, String mediaType, String sectionId);

    void getMetadataDetails(String ratingKey, String syncId, String plexGuid, String sectionId, boolean skipCache, String cacheKey, boolean returnCache, boolean mediaInfo);

    void getMetadataChildrenDetails(String ratingKey, boolean getChildren);

    void getLibraryMetadataDetails(String sectionId);

    void getCurrentActivity(boolean skipCache);

    void getSessionEach(String session, boolean skipCache);

    void terminateSession(String sessionKey, String sessionId, String message);

    void getItemChildren(String ratingKey, String mediaType, boolean getGrandChildren);

    void getItemChildrenRelated(String ratingKey);

    void getServerInfo();

    void getServerIdentity();

    void getServerPrefs(String prefs);

    void getServerChildren();

    void getLibraryChildrenDetails(String sectionId, String sectionType, String listType, String count, String ratingKey, String labelKey, boolean getMediaInfo);

    void getLibraryDetails();

    void getLibraryLabelDetails(String sectionId);

    void getImage(String img, long width, long height, String opacity, String background, String blur, String imgFormat, boolean clip, boolean refresh);

    void getSearchResults(String query, String limit);

    void getRatingKeysList(String ratingKey, String mediaType);

    void getServerResponse();

    void getUpdateStatus();

    void getServerVersion();

    void getServerUpdateChannel();
}
