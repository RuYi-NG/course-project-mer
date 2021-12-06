package com.mer.plamer.usecases;

import com.mer.plamer.entities.Admin;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.Track;

/**
 * Actions that a user can perform
 */
public class UserAction {

    private User user;

    /**
     * Constructor for UserAction, it will have no user at the beginning.
     */
    public UserAction() {
        this.user = null;
    }

    /**
     * Set the user this UserAction is dealing with.
     *
     * @param username the username of the user in interest.
     */
    public void setUser(String username) {
        this.user = UserLibraryAction.userLibrary.get(username);
    }

    /**
     * Return the user this UserAction is dealing with.
     *
     * @return The user this UserAction is dealing with.
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Check if this UserAction is no user assign.
     *
     * @return Whether there is a user assigned.
     */
    public boolean isNull() {
        return this.user == null;
    }

    public boolean isAdmin() {
        return this.getUser() instanceof Admin;
    }

    public String getCurrentName() {
        return this.getUser().getUsername();
    }

    public String getCurrentPassword() {
        return this.getUser().getPassword();
    }

    /**
     * Change the password of a user.
     *
     * @param new_pass The desired password that this user want to change to.
     * @return true if the password is changed, false if did not or is the same as the old one.
     */
    public boolean changePwd(String new_pass) {
        if (this.isNull() || new_pass.equals(this.user.getPassword())) {
            return false;
        }
        this.user.setPassword(new_pass);
        return true;
    }

    /**
     * Change the username of a user.
     *
     * @param new_name The desired username that this user want to change to.
     * @return true if the username is changed, false if did not or is the same as the old one.
     */
    public boolean changeName(String new_name) {
        if (this.isNull() || new_name.equals(this.user.getUsername())) {
            return false;
        }
        this.user.setUsername(new_name);
        return true;
    }

    public void addPlaylist(Playlist playList){

    }
}
