package com.cinemon.domain.services.impl;

import com.cinemon.domain.services.PlexService;
import org.springframework.beans.factory.annotation.Value;

public class PlexServiceImpl implements PlexService {

    @Value("${pms.url}")
    private String url;

    @Value("${pms.port}")
    private String port;

    @Value("${pms.token")
    private String authToken;
    
    @Override
    public void getSessions() {

    }

    @Override
    public void getSessionsTerminate() {

    }

    @Override
    public void getMetadata(String ratingKey) {

    }

    @Override
    public void getMetadataChildren(String ratingKey, String sectionId, boolean artist, boolean collection) {

    }

    @Override
    public void getMetadataGrandChildren(String ratingKey) {

    }

    @Override
    public void getPlaylistItem(String ratingKey) {

    }

    @Override
    public void getRecentlyAdded(String start, String count) {

    }

    @Override
    public void getLibraryRecetlyAdded(String sectionId, String start, String count) {

    }

    @Override
    public void getChildrenListRelated(String ratingKey) {

    }

    @Override
    public void getChildrensList(String ratingKey) {

    }

    @Override
    public void getServerList() {

    }

    @Override
    public void getServerPrefs() {

    }

    @Override
    public void getLocalServerIdentity() {

    }

    @Override
    public void getLibrariesList() {

    }

    @Override
    public void getLibraryList(String sectionId, String listType, String count, String sortType, String labelKey) {

    }

    @Override
    public void getLibraryLabels(String sectionId) {

    }

    @Override
    public void getSyncItems(String syncId) {

    }

    @Override
    public void getSyncTranscodeQueue() {

    }

    @Override
    public void getSearch(String query, String limit) {

    }

    @Override
    public void getAccount() {

    }

    @Override
    public void putRefreshReachability() {

    }

    @Override
    public void putUpdater() {

    }

    @Override
    public void getUpdater() {

    }

    @Override
    public void getHubRecentlyAdded(String start, String count, String mediaType, boolean otherVideo) {

    }

    @Override
    public void getRecentlyAddedDetails(String start, String count, String mediaType, String sectionId) {

    }

    @Override
    public void getMetadataDetails(String ratingKey, String syncId, String plexGuid, String sectionId, boolean skipCache, String cacheKey, boolean returnCache, boolean mediaInfo) {

    }

    @Override
    public void getMetadataChildrenDetails(String ratingKey, boolean getChildren) {

    }

    @Override
    public void getLibraryMetadataDetails(String sectionId) {

    }

    @Override
    public void getCurrentActivity(boolean skipCache) {

    }

    @Override
    public void getSessionEach(String session, boolean skipCache) {

    }

    @Override
    public void terminateSession(String sessionKey, String sessionId, String message) {

    }

    @Override
    public void getItemChildren(String ratingKey, String mediaType, boolean getGrandChildren) {

    }

    @Override
    public void getItemChildrenRelated(String ratingKey) {

    }

    @Override
    public void getServerInfo() {

    }

    @Override
    public void getServerIdentity() {

    }

    @Override
    public void getServerPrefs(String prefs) {

    }

    @Override
    public void getServerChildren() {

    }

    @Override
    public void getLibraryChildrenDetails(String sectionId, String sectionType, String listType, String count, String ratingKey, String labelKey, boolean getMediaInfo) {

    }

    @Override
    public void getLibraryDetails() {

    }

    @Override
    public void getLibraryLabelDetails(String sectionId) {

    }

    @Override
    public void getImage(String img, long width, long height, String opacity, String background, String blur, String imgFormat, boolean clip, boolean refresh) {

    }

    @Override
    public void getSearchResults(String query, String limit) {

    }

    @Override
    public void getRatingKeysList(String ratingKey, String mediaType) {

    }

    @Override
    public void getServerResponse() {

    }

    @Override
    public void getUpdateStatus() {

    }

    @Override
    public void getServerVersion() {

    }

    @Override
    public void getServerUpdateChannel() {

    }
}
