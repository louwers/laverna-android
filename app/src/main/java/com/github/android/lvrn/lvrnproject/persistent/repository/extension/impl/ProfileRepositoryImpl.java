package com.github.android.lvrn.lvrnproject.persistent.repository.extension.impl;

import android.content.ContentValues;
import android.database.Cursor;

import com.github.android.lvrn.lvrnproject.persistent.entity.Profile;
import com.github.android.lvrn.lvrnproject.persistent.repository.extension.ProfileRepository;
import com.github.android.lvrn.lvrnproject.persistent.repository.impl.BasicRepositoryImpl;

import java.util.List;

import static com.github.android.lvrn.lvrnproject.persistent.database.LavernaContract.ProfilesTable.COLUMN_ID;
import static com.github.android.lvrn.lvrnproject.persistent.database.LavernaContract.ProfilesTable.COLUMN_PROFILE_NAME;
import static com.github.android.lvrn.lvrnproject.persistent.database.LavernaContract.ProfilesTable.TABLE_NAME;

/**
 * @author Vadim Boitsov <vadimboitsov1@gmail.com>
 */

public class ProfileRepositoryImpl extends BasicRepositoryImpl<Profile> implements ProfileRepository {

    public ProfileRepositoryImpl() {
        super(TABLE_NAME);
    }

    @Override
    protected ContentValues toContentValues(Profile entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, entity.getId());
        contentValues.put(COLUMN_PROFILE_NAME, entity.getName());
        return contentValues;
    }

    @Override
    protected Profile toEntity(Cursor cursor) {
        return new Profile(
                cursor.getString(cursor.getColumnIndex(COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMN_PROFILE_NAME)));
    }

    /**
     * A method which retrieves all profiles.
     * @return a list of profiles.
     */
    @Override
    public List<Profile> getAllProfiles() {
        String query = "SELECT * FROM " + TABLE_NAME;
        return getByRawQuery(query);
    }
}