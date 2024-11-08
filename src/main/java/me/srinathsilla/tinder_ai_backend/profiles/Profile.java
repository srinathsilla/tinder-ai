package me.srinathsilla.tinder_ai_backend.profiles;

public record Profile(
        String id,
        String firstName,
        String lastName,
        String age,
        String ethnicity,
        Gender gender,
        String bio,
        String imageUrl,
        String myersBriggsType
) {
}
