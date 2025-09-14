package music.business.repository;

import music.business.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
