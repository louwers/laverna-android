package com.github.android.lvrn.lvrnproject.persistent.repository.core;

import android.support.annotation.NonNull;

import com.github.android.lvrn.lvrnproject.persistent.entity.Notebook;
import com.github.android.lvrn.lvrnproject.persistent.repository.TrashDependedRepository;
import com.github.android.lvrn.lvrnproject.util.PaginationArgs;

import java.util.List;

/**
 * @author Vadim Boitsov <vadimboitsov1@gmail.com>
 */

public interface NotebookRepository extends TrashDependedRepository<Notebook> {

    /**
     * A method which retrieves an amount of entities from a start position by a name.
     * @param profileId an id of profile.
     * @param name a required name.
     * @param offset a start position.
     * @param limit a number of entities to retrieve.
     * @return a list of entities.
     */
    @NonNull
    List<Notebook> getByName(@NonNull String profileId, @NonNull String name, boolean isTrash, @NonNull PaginationArgs paginationArgs);

    /**
     * A method which retrieves an amount of entities from a start position by a parent notebook's id.
     * @param notebookId an id of a parent notebook.
     * @param offset a start position.
     * @param limit a number of entities to retrieve.
     * @return a list of entities.
     */
    @NonNull
    List<Notebook> getChildren(@NonNull String notebookId, boolean isTrash, @NonNull PaginationArgs paginationArgs);

    /**
     * A method which retrieves an amount of entities from a start position which are root parents (has no parent).
     * @param profileId an id of profile.
     * @param offset a start position.
     * @param limit a number of entities to retrieve.
     * @return a list of entities.
     */
    @NonNull
    List<Notebook> getRootParents(@NonNull String profileId, boolean isTrash, @NonNull PaginationArgs paginationArgs);
}