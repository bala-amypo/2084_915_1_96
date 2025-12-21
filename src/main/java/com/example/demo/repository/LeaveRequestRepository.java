package com.example.demo.repository;

import com.example.demo.model.LeaveRequest;
import com.example.demo.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    // REQUIRED by test
    List<LeaveRequest> findByEmployee(EmployeeProfile employee);

    // REQUIRED by test (exact name)
    @Query("""
        SELECT lr FROM LeaveRequest lr
        WHERE lr.employee.teamName = :teamName
          AND lr.status = 'APPROVED'
          AND lr.startDate <= :end
          AND lr.endDate >= :start
    """)
    List<LeaveRequest> findApprovedOverlappingForTeam(
            @Param("teamName") String teamName,
            @Param("start") LocalDate start,
            @Param("end") LocalDate end
    );
}
