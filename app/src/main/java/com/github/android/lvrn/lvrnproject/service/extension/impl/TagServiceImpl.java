package com.github.android.lvrn.lvrnproject.service.extension.impl;

import android.support.annotation.NonNull;

import com.github.android.lvrn.lvrnproject.persistent.entity.Tag;
import com.github.android.lvrn.lvrnproject.persistent.repository.extension.TagRepository;
import com.github.android.lvrn.lvrnproject.service.extension.ProfileService;
import com.github.android.lvrn.lvrnproject.service.extension.TagService;
import com.github.android.lvrn.lvrnproject.service.form.TagForm;
import com.github.android.lvrn.lvrnproject.service.impl.ProfileDependedServiceImpl;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

/**
 * @author Vadim Boitsov <vadimboitsov1@gmail.com>
 */

public class TagServiceImpl extends ProfileDependedServiceImpl<Tag, TagForm> implements TagService {

    private final TagRepository mTagRepository;

    @Inject
    public TagServiceImpl(@NonNull TagRepository tagRepository, @NonNull ProfileService profileService) {
        super(tagRepository, profileService);
        mTagRepository = tagRepository;
    }

    @Override
    public void create(@NonNull TagForm tagForm) {
        validateForCreate(tagForm.getProfileId(),tagForm.getName());
        mTagRepository.add(tagForm.toEntity(UUID.randomUUID().toString()));
    }

    @Override
    @Deprecated
    public void update(@NonNull String id, @NonNull TagForm tagForm) {
        //TODO: will appear in future milestone if Laverna implements this method properly.
//        validateForUpdate(tagForm.getName());
//        mTagRepository.update(tagForm.toEntity(id));
    }

    @NonNull
    @Override
    public List<Tag> getByName(@NonNull String name, int from, int amount) {
        return mTagRepository.getByName(name, from, amount);
    }

    @NonNull
    @Override
    public List<Tag> getByNote(@NonNull String noteId) {
        return mTagRepository.getByNote(noteId);
    }

    /**
     * A method which validates a form in the create method.
     * @param profileId and id of profile to validate.
     * @param name an id of the entity to validate.
     */
    private void validateForCreate(String profileId, String name) {
        checkProfileExistence(profileId);
        checkName(name);
    }

//    private void validateForUpdate(String name) {
//        checkName(name);
//    }
}
