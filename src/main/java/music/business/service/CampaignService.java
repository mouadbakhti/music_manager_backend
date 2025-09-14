package music.business.service;

import music.business.entity.Campaign;
import music.business.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Optional<Campaign> getCampaignById(Long id) {
        return campaignRepository.findById(id);
    }

    public Campaign createCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public Optional<Campaign> updateCampaign(Long id, Campaign updatedCampaign) {
        return campaignRepository.findById(id).map(campaign -> {
            campaign.setName(updatedCampaign.getName());
            campaign.setDescription(updatedCampaign.getDescription());
            campaign.setStartDate(updatedCampaign.getStartDate());
            campaign.setEndDate(updatedCampaign.getEndDate());
            campaign.setBudget(updatedCampaign.getBudget());
            campaign.setStatus(updatedCampaign.getStatus());
            return campaignRepository.save(campaign);
        });
    }

    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }

}
