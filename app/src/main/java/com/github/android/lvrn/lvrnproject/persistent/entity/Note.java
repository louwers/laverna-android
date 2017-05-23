package com.github.android.lvrn.lvrnproject.persistent.entity;

import android.support.annotation.NonNull;

/**
 * @author Vadim Boitsov <vadimboitsov1@gmail.com>
 */

public class Note extends ProfileDependedEntity {

    /**
     * An id of a notebook, which the note is belonged. In case, if the note doesn't belong to any
     * notebook, then notebookId equals to "0".
     */
    private String notebookId;

    private String title;

    /**
     * A date of the model's creation in milliseconds.
     */
    private long creationTime;

    /**
     * A date of the model's creation in milliseconds.
     */
    private long updateTime;

    /**
     * A plain text of a note's content.
     */
    private String content;

    /**
     * A note's content in html.
     */
    private String htmlContent;

    private boolean isFavorite = false;

    public Note(String id,
                String profileId,
                String notebookId,
                String title,
                long creationTime,
                long updateTime,
                String content,
                String htmlContent,
                boolean isFavorite) {
        this.id = id;
        this.profileId = profileId;
        this.notebookId = notebookId;
        this.title = title;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
        this.content = content;
        this.htmlContent = htmlContent;
        this.isFavorite = isFavorite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(String notebookId) {
        this.notebookId = notebookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @NonNull
    @Override
    public String toString() {
        return "Note{" + super.toString() +
                "notebookId='" + notebookId + '\'' +
                ", title='" + title + '\'' +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", content='" + content + '\'' +
                ", isFavorite=" + isFavorite +
                '}';
    }
}
