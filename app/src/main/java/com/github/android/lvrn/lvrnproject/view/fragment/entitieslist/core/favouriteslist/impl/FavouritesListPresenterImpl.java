package com.github.android.lvrn.lvrnproject.view.fragment.entitieslist.core.favouriteslist.impl;

import com.github.android.lvrn.lvrnproject.service.core.NoteService;
import com.github.android.lvrn.lvrnproject.service.form.NoteForm;
import com.github.android.lvrn.lvrnproject.util.CurrentState;
import com.github.android.lvrn.lvrnproject.util.PaginationArgs;
import com.github.android.lvrn.lvrnproject.view.fragment.entitieslist.core.favouriteslist.FavouritesListPresenter;
import com.github.android.lvrn.lvrnproject.view.fragment.entitieslist.impl.EntitiesListWithSearchPresenterImpl;
import com.github.valhallalabs.laverna.persistent.entity.Note;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Andrii Bei <psihey1@gmail.com>
 */

public class FavouritesListPresenterImpl extends EntitiesListWithSearchPresenterImpl<Note, NoteForm> implements FavouritesListPresenter {

    private NoteService mNoteService;

    @Inject
    public FavouritesListPresenterImpl(NoteService entityService) {
        super(entityService);
        mNoteService = entityService;
    }

    @Override
    protected List<Note> loadMoreForPagination(PaginationArgs paginationArgs) {
        return mNoteService.getFavourites(CurrentState.profileId, paginationArgs);
    }

    @Override
    protected List<Note> loadMoreForSearch(String query, PaginationArgs paginationArgs) {
        return mNoteService.getFavouritesByTitle(CurrentState.profileId, query, paginationArgs);
    }
}
