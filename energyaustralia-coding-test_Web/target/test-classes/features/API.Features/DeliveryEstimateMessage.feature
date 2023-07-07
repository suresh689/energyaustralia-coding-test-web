Feature: Verify All delivery estimate message

  @DeliveryEstimateMessage
  Scenario Outline: Verify default delivery estimate message
    Given select language as "<language>"
    When verify delivery estimate message with "GET" http request
    Then The API call got success with status code
    And verify "delivery estimate" with "1"
    Examples:
      | language |  |
      | en       |  |
      | ar       |  |
