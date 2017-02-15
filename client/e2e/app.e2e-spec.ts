import { ClientModulePage } from './app.po';

describe('client-module App', function() {
  let page: ClientModulePage;

  beforeEach(() => {
    page = new ClientModulePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
