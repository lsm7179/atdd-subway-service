package nextstep.subway.path.dto;

import nextstep.subway.path.domain.Path;
import nextstep.subway.station.dto.StationResponse;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class PathResponse {
    private List<StationResponse> stations;
    private Long distance;

    public PathResponse(List<StationResponse> stations, Long distance) {
        this.stations = stations;
        this.distance = distance;
    }

    public static PathResponse of(Path path) {
        List<StationResponse> stations = path.getStations()
                .stream()
                .map(StationResponse::of)
                .collect(Collectors.toList());
        return new PathResponse(stations, path.getDistance());
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public Long getDistance() {
        return distance;
    }

    public BigInteger getFare() {
        return null;
    }
}
