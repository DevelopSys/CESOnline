package org.example.gestor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipo implements Serializable {
    private String intRank, strTeam, intPoints, strBadge, strDescription;
}
