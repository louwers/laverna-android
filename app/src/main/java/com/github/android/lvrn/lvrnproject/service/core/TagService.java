package com.github.android.lvrn.lvrnproject.service.core;

import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.github.android.lvrn.lvrnproject.persistent.entity.Tag;
import com.github.android.lvrn.lvrnproject.service.ProfileDependedService;
import com.github.android.lvrn.lvrnproject.service.form.TagForm;
import com.github.android.lvrn.lvrnproject.util.PaginationArgs;

import java.util.List;

/**
 * @author Vadim Boitsov <vadimboitsov1@gmail.com>
 */

public interface TagService extends ProfileDependedService<Tag, TagForm> {

    /**
     * A method which retrieves an amount of entities from a start position by a name.
     * @param name a required name.
     * @param offset a start position.
     * @param limit a number of entities to retrieve.
     * @return a list of entities.
     */
    //TODO: does it depend to profile?
    @NonNull
    List<Tag> getByName(@NonNull String profileId, @NonNull String name, @NonNull PaginationArgs paginationArgs);

    /**
     * A method which retrieves all entities by a note id.
     * @param noteId an id of note.
     * @return a list of entities.
     */
    @NonNull
    List<Tag> getByNote(@NonNull String noteId);
}
