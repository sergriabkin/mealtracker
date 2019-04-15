package com.mealtracker.service;

import com.mealtracker.model.Meal;
import com.mealtracker.util.exception.NotFoundException;
import org.springframework.lang.Nullable;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.mealtracker.util.DateTimeUtil.adjustEndDateTime;
import static com.mealtracker.util.DateTimeUtil.adjustStartDateTime;

public interface MealService {
    Meal get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    default List<Meal> getBetweenDates(@Nullable LocalDate startDate, @Nullable LocalDate endDate, int userId) {
        return getBetweenDateTimes(adjustStartDateTime(startDate), adjustEndDateTime(endDate), userId);
    }

    List<Meal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);

    List<Meal> getAll(int userId);

    void update(Meal meal, int userId) throws NotFoundException;

    Meal create(Meal meal, int userId);
}